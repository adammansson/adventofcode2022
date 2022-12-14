package aoc.y2022.day14
import problemutils.*, extensions.*

def parse(data: List[String]): Vector[Vector[(Int, Int)]] =
  data.map(_.split(" -> ").map(_.split(",")).map(xs => (xs(0).toInt, xs(1).toInt)).toVector).toVector

