package aoc.y2022.day07
import problemutils.*
import extensions.*

import scala.collection.mutable

def parse(data: List[String]): Map[String, Map[String, Int]] =
  val dirs = mutable.Stack[String]()
  val dirSizes = mutable.Map[String, mutable.Map[String, Int]]()

  for line <- data.map(_.split(" ").toVector) do
    line match
      case Vector("$", cmd, arg) =>
        cmd match
          case "cd" =>
            arg match
              case ".." => dirs.pop()
              case _ => dirs.push(line(2))

      case Vector(s0, s1) if s0.forall(_.isDigit) =>
        val fSize = s0.toInt
        val fName = s1
        val filePath = fName + "/" + dirs.mkString("/")

        for i <- dirs.indices do
          val dirPath = dirs.toVector.drop(i).mkString("/")
          val files = dirSizes.getOrElse(dirPath, mutable.Map[String, Int]())
          if !files.isDefinedAt(filePath) then
            dirSizes += (dirPath -> (files += (filePath -> fSize)))

      case _ =>

  dirSizes.map((k, v) => k -> v.toMap).toMap
