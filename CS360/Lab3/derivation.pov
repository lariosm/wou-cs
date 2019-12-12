/*
  Manuel Larios
  CS360
*/


#include "colors.inc"


camera { perspective location <10, 5, 0> look_at <0, 0, 0> }

light_source { <10, 10, -10>, color rgb <255, 255, 0> }

cylinder { <0, 0, 0>, <0, 4, 0>, 0.75 pigment {color Cyan} finish { ambient Blue } }

plane { <0, -1, 0>, 50.0 pigment {color Green} }                                                            