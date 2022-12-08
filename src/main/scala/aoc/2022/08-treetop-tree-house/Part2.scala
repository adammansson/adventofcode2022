package aoc.y2022.day08
import paut.aoc.*
import problemutils.*, extensions.*

object Part2 extends Problem(8, 2022)(2)(8):
  def name = "Treetop Tree House - Part 2"
  def solve(data: List[String]): Int = parse(data).zipWithIndex.map((xs, y) => xs.zipWithIndex.map((i, x) => {
    var nx = x
    var px = x
    var ny = y
    var py = y
    var continue = true

    while nx > 0 && continue do
      nx -= 1
      if xs(nx) >= i then
        continue = false

    continue = true
    while px < xs.length - 1 && continue do
      px += 1
      if xs(px) >= i then
        continue = false

    continue = true
    while ny > 0 && continue do
      ny -= 1
      if parse(data)(ny)(x) >= i then
        continue = false

    continue = true
    while py < parse(data).length - 1 && continue do
      py += 1
      if parse(data)(py)(x) >= i then
        continue = false

    (x - nx) * (px - x) * (y - ny) * (py - y)
  }).max).max
