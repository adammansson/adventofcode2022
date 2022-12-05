package aoc.y2022.day05
import paut.aoc.*
import problemutils.*, extensions.*

object Part1 extends Problem(5, 2022)(1)("CMZ"):
  def name = "Supply Stacks - Part 1"
  def solve(data: List[String]): String =
    val (stacks, instructions) = parse(data)

    for i <- instructions.indices do
      for _ <- 0 until instructions(i)(0) do
        stacks(instructions(i)(2) - 1).push(stacks(instructions(i)(1) - 1).pop)

    stacks.map(s => s.pop).mkString("")
