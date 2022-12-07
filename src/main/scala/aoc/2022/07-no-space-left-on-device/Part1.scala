package aoc.y2022.day07
import paut.aoc.*
import problemutils.*
import extensions.*

import scala.collection.mutable

object Part1 extends Problem(7, 2022)(1)(95437):
  def name = "No Space Left On Device - Part 1"
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

              for i <- dirs.indices do
                val filePath = dirs.toVector.drop(i).mkString("/")
                val files = dirSizes.getOrElse(filePath, mutable.Map[String, Int]())

                if !files.isDefinedAt(fName) then
                  dirSizes += (filePath -> (files += (fName -> fSize)))

    dirSizes.map((_, f) => f.values.sum).filter(i => i <= 100000).sum