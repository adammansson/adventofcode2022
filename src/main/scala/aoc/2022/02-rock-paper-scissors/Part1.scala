package aoc.y2022.day02
import paut.aoc.*
import problemutils.*, extensions.*

object Part1 extends Problem(2, 2022)(1)(15):
  def name = "Rock Paper Scissors - Part 1"
  
  def outcome(left: String, right: String): Int =
    left match
      case "A" =>
        right match
          case "X" => 3 + 1
          case "Y" => 6 + 2
          case "Z" => 0 + 3
      case "B" =>
        right match
          case "X" => 0 + 1
          case "Y" => 3 + 2
          case "Z" => 6 + 3
      case "C" =>
        right match
          case "X" => 6 + 1
          case "Y" => 0 + 2
          case "Z" => 3 + 3
          
  def solve(data: List[String]) = parse(data).map(xs => outcome(xs(0), xs(1))).sum
