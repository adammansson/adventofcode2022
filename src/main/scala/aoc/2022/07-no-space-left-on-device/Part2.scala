package aoc.y2022.day07
import paut.aoc.*
import problemutils.*
import extensions.*

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Part2 extends Problem(7, 2022)(2)(24933642):
  def name = "No Space Left On Device - Part 2"
  def solve(data: List[String]): Int =
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

    val total = 70000000
    val neededForUpdate = 30000000
    //val used = dirSizes.map((_, f) => f.values.sum).sum
    val used = dirSizes("/").values.sum
    val unused = total - used
    val mustBeDeleted = neededForUpdate - unused
    println(mustBeDeleted)
    dirSizes.map((_, f) => f.values.sum).filter(i => i >= mustBeDeleted).toVector.sorted.head
