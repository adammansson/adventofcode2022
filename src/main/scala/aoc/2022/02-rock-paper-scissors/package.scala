package aoc.y2022.day02
import problemutils.*, extensions.*

def parse(data: List[String]): List[Vector[String]] = data.map(_.split(" ").toVector)
