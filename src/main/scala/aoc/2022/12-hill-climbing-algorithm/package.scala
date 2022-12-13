package aoc.y2022.day12
import problemutils.*, extensions.*

def okDiff(current: Char, other: Char): Boolean =
  ((if (other == 'E') 'z' else other) - (if (current == 'S') 'a' else current)) <= 1

def parse(data: List[String]) = data.map(_.toCharArray.toVector).toVector
