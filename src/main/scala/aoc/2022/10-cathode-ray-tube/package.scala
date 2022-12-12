package aoc.y2022.day10
import problemutils.*, extensions.*

// def parse(data: List[String]): List[Vector[String]] = data.map(s => s.split(" ").toVector)
def parse(data: List[String]): List[Vector[String]] = data.map(s => s.split(" ").toVector).flatMap(a => if (a(0) == "addx") Vector(Vector("noop"), a) else Vector(a))
