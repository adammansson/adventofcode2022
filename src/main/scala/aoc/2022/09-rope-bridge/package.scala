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
    else if x == other.x then
      if other.y > y then
        Pos(x, y + 1)
      else
        Pos(x, y - 1)
    else if y == other.y then
      if other.x > x then
        Pos(x + 1, y)
      else
        Pos(x - 1, y)
    else
      val dx = other.x - x
      val dy = other.y - y
      if dx > 0 && dy > 0 then
        Pos(x + 1, y + 1)
      else if dx > 0 && dy < 0 then
        Pos(x + 1, y - 1)
      else if dx < 0 && dy > 0 then
        Pos(x - 1, y + 1)
      else
        Pos(x - 1, y - 1)

def parse(data: List[String]): List[(String, Int)] =
  for line <- data yield
    val split = line.split(" ")
    (split(0), split(1).toInt)
