package aoc.y2022.day02
import paut.aoc.*
import problemutils.*, extensions.*

object Part2 extends Problem(2, 2022)(2)(12):
  def name = "Rock Paper Scissors - Part 2"

  def outcome(left: String, right: String): Int =
    left match
      case "A" =>
        right match
          case "X" => 0 + 3
          case "Y" => 3 + 1
          case "Z" => 6 + 2
      case "B" =>
        right match
          case "X" => 0 + 1
          case "Y" => 3 + 2
          case "Z" => 6 + 3
      case "C" =>
        right match
          case "X" => 0 + 2
          case "Y" => 3 + 3
          case "Z" => 6 + 1

  def solve(data: List[String]) = parse(data).map(xs => outcome(xs(0), xs(1))).sum
