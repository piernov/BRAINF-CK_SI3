#!/bin/bash

for i in svgL3/*.svg; do
	inkscape -z -C -f${i} -EsvgL3/`basename -s .svg ${i}`.eps
done
lualatex --shell-escape L3.tex
