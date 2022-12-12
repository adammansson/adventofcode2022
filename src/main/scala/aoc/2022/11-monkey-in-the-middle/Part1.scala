package aoc.y2022.day11
import paut.aoc.*
import problemutils.*, extensions.*

object Part1 extends Problem(11, 2022)(1)(10605):
  def name = "Monkey in the Middle - Part 1"
  def solve(data: List[String]) =
    val monkeys = parse(data)
    for turn <- 0 until 20 do
      for monk <- monkeys do
        val initialLength = monk.items.length
        for _ <- 0 until initialLength  do
          var worryLevel = monk.items(0)
          val operand = if (monk.operation(1) == "old") worryLevel else monk.operation(1).toInt
          if monk.operation(0) == "*" then
            worryLevel *= operand
          else
            worryLevel += operand
          worryLevel = (worryLevel / 3.0).floor.toInt
          if worryLevel % monk.test(0) == 0 then
            monkeys(monk.test(1)).items.addOne(worryLevel)
          else
            monkeys(monk.test(2)).items.addOne(worryLevel)

          monk.items.remove(0)
          monk.timesInspected += 1

    val res = monkeys.map(m => m.timesInspected).sorted.reverse.take(2)
    res(0) * res(1)