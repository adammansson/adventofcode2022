package aoc.y2022.day13
import paut.aoc.*
import problemutils.*
import extensions.*

import scala.collection.mutable

object Part1 extends Problem(13, 2022)(1)(13):
  def name = "Distress Signal - Part 1"
  def solve(data: List[String]) =
    var i = 0
    for (pair, index) <- parse(data).zipWithIndex do
      if rightOrder(parseList(pair(0)), parseList(pair(1))) == 1 then
        i += index + 1
        println("right order\n")
      else
        println("not right order\n")

    i

  def rightOrder(l0: Vector[String], l1: Vector[String]): Int =
    println(s"Compare ${l0} vs ${l1}")
    var res = 0
    var i = 0
    var running = true

    while running do
      running = false
      if i >= l0.length && i >= l1.length then
        res = 0
      else if i >= l0.length then
        res = 1
      else if i >= l1.length then
        res = -1
      else
        println(s"Compare ${l0(i)} vs ${l1(i)}")
        if l0(i).startsWith("[") && l1(i).startsWith("[") then
          res = rightOrder(parseList(l0(i)), parseList(l1(i)))
          if res == 0 then
            running = true
        else if l0(i).startsWith("[") then
          res = rightOrder(parseList(l0(i)), Vector(l1(i)))
          if res == 0 then
            running = true
        else if l1(i).startsWith("[") then
          res = rightOrder(Vector(l0(i)), parseList(l1(i)))
          if res == 0 then
            running = true
        else
          if l0(i).toInt < l1(i).toInt then
            res = 1
          else if l0(i).toInt > l1(i).toInt then
            res = -1
          else
            res = 0
            running = true
      i += 1
    res