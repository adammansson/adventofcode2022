package aoc.y2022.day03
import problemutils.*, extensions.*

def priority(c: Char): Int =
  if c.isLower then c - 'a' + 1
  else c - 'A' + 27
  