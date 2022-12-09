package aoc.y2022.day09
import problemutils.*, extensions.*

case class Pos(x: Int, y: Int):
  def isTouching(other: Pos): Boolean =
    (x - other.x).abs <= 1 && (y - other.y).abs <= 1

  def moved(dir: String): Pos =
    dir match
      case "U" => Pos(x, y - 1)
      case "R" => Pos(x + 1, y)
      case "D" => Pos(x, y + 1)
      case _ => Pos(x - 1, y)

  def followed(other: Pos): Pos =
    if isTouching(other) then
      Pos(x, y)
    else
      val mx = if (other.x == x) 0 else if (other.x > x) 1 else -1
      val my = if (other.y == y) 0 else if (other.y > y) 1 else -1
      Pos(x + mx, y + my)

def parse(data: List[String]): List[(String, Int)] =
  for line <- data yield
    val split = line.split(" ")
    (split(0), split(1).toInt)
