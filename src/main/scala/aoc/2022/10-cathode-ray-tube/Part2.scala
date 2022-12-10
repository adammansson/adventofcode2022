package aoc.y2022.day10
import paut.aoc.*
import problemutils.*
import extensions.*

import scala.collection.mutable.ArrayBuffer

object Part2 extends Problem(10, 2022)(2)(0):
  def name = "Cathode-Ray Tube - Part 2"
  def solve(data: List[String]): Int =
    val crt = Vector.fill(6)(ArrayBuffer[Char]())
    var counter = 0
    var reg = 1
    var crtRow = 0
    var crtCol = 0

    for line <- parse(data) do
      if line(0) == "addx" then
        crtCol = counter % 40
        counter += 1
        crtRow = (counter - 1) / 40
        if (reg - crtCol).abs <= 1 then
          crt(crtRow).addOne('#')
        else
          crt(crtRow).addOne('.')

        crtCol = counter % 40
        counter += 1
        crtRow = (counter - 1) / 40
        if (reg - crtCol).abs <= 1 then
          crt(crtRow).addOne('#')
        else
          crt(crtRow).addOne('.')

        reg += line(1).toInt
      else
        crtCol = counter % 40
        counter += 1
        crtRow = (counter - 1) / 40
        if (reg - crtCol).abs <= 1 then
          crt(crtRow).addOne('#')
        else
          crt(crtRow).addOne('.')

    println(crt.map(_.mkString("")).mkString("\n"))
    0
