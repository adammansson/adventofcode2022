package aoc.y2022.day07
import problemutils.*
import extensions.*

import scala.collection.mutable

def parse(data: List[String]): Map[String, Map[String, Int]] =
  val dirs = mutable.Stack[String]()
  val dirSizes = mutable.Map[String, mutable.Map[String, Int]]()

  for line <- data do
    val split = line.split(" ").toVector

    if split(0) == "$" then
      if  split(1) == "cd" then
        if split(2) == ".." then
          dirs.pop()
        else
          dirs.push(split(2))

    else
      if split(0) != ("dir") then
        val fSize = split(0).toInt
        val fName = split(1)
        val filePath = fName + "/" + dirs.mkString("/")

        for i <- dirs.indices do
          val dirPath = dirs.toVector.drop(i).mkString("/")
          val files = dirSizes.getOrElse(dirPath, mutable.Map[String, Int]())
          if !files.isDefinedAt(filePath) then
            dirSizes += (dirPath -> (files += (filePath -> fSize)))

  dirSizes.map((k, v) => (k -> v.toMap)).toMap
