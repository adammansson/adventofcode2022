package aoc.y2022.day08
import paut.aoc.*
import problemutils.*, extensions.*

object Part1 extends Problem(8, 2022)(1)(21):
  def name = "Treetop Tree House - Part 1"
  def solve(data: List[String]): Int = parse(data).zipWithIndex.map((xs, y) => xs.zipWithIndex.count((i, x) => {
    var nx = x
    var px = x
    var ny = y
    var py = y

    while nx > 0 do
      nx -= 1
      if xs(nx) >= i then
        nx = -1

    while px < xs.length - 1 do
      px += 1
      if xs(px) >= i then
        px = xs.length

    while ny > 0 do
      ny -= 1
      if parse(data)(ny)(x) >= i then
        ny = -1

    while py < parse(data).length - 1 do
      py += 1
      if parse(data)(py)(x) >= i then
        py = parse(data).length

    nx != -1 || px != xs.length || ny != -1 || py != parse(data).length
  })).sum
