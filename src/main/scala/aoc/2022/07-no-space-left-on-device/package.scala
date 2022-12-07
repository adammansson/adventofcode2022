package aoc.y2022.day07
import problemutils.*
import extensions.*

import scala.collection.mutable

def parse(data: List[String]): Map[String, Map[String, Int]] =
  val dirs = mutable.Stack[String]()
  val dirSizes = mutable.Map[String, mutable.Map[String, Int]]()

  for line <- data.map(_.split(" ").toVector) do
    if line(0) == "$" then
      if  line(1) == "cd" then
        if line(2) == ".." then
          dirs.pop()
        else
          dirs.push(line(2))

    else
      if line(0) != ("dir") then
        val fSize = line(0).toInt
        val fName = line(1)
        val filePath = fName + "/" + dirs.mkString("/")

        for i <- dirs.indices do
          val dirPath = dirs.toVector.drop(i).mkString("/")
          val files = dirSizes.getOrElse(dirPath, mutable.Map[String, Int]())
          if !files.isDefinedAt(filePath) then
            dirSizes += (dirPath -> (files += (filePath -> fSize)))

  dirSizes.map((k, v) => (k -> v.toMap)).toMap
