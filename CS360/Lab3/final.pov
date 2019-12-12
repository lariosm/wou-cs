/*
  Manuel Larios
  CS360
*/

#include "colors.inc"


camera { 
    perspective 
    location <10, 5, 0> 
    look_at <0, 0, 0>
}

light_source {
    <10, 10, -10>, 
    color rgb <255, 255, 0> 
}

union {
    torus { 
        1.5, 
        0.75 
        translate <0, 2, 0> 
        pigment {
            color Yellow
        } 
        finish { 
            ambient Red 
        } 
    }
    intersection {
        cylinder { 
            <0, 0, 0>, 
            <0, 4, 0>, 
            0.75 
            pigment {
                color Cyan
            } 
            finish {
                ambient Blue 
            } 
        }        
    }
    difference {        
        box { 
            <-2, 3, 2>, 
            <2, 1, -2> 
            pigment {
                color Magenta
            } 
            finish { 
                ambient Blue 
            } 
        }        
    }
}

plane { 
    <0, -1, 0>, 
    50.0 
    pigment {
        color Green
    } 
} 