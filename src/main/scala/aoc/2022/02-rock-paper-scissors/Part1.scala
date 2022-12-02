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
          case _ => 0 + 3
      case "B" =>
        right match
          case "X" => 0 + 1
          case "Y" => 3 + 2
          case _ => 6 + 3
      case _ =>
        right match
          case "X" => 6 + 1
          case "Y" => 0 + 2
          case _ => 3 + 3
          
  def solve(data: List[String]) = parse(data).map(xs => outcome(xs(0), xs(1))).sum
