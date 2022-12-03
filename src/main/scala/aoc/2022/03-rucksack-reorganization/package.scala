package aoc.y2022.day03
import problemutils.*, extensions.*

def priority(c: Char): Int =
  if 'a' <= c && c <= 'z' then c - 'a' + 1
  else if 'A' <= c && c <= 'Z' then c - 'A' + 27
  else 0

def parse(data: List[String]) = ???