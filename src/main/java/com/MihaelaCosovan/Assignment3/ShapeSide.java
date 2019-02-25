package com.MihaelaCosovan.Assignment3;

import java.util.List;
import java.util.ArrayList;

public class ShapeSide {

    public List<String> getAvailableShapes(GeometricShape type){

        @SuppressWarnings({ "unchecked", "rawtypes" })
		List<String> shape = new ArrayList();

        if(type.equals(GeometricShape.Shape3)){
        	shape.add("Triangle");

        }else if(type.equals(GeometricShape.Shape4)){
        	shape.add("Square");
        	shape.add("Rectangle");

        }else if(type.equals(GeometricShape.Shape5)){
        	shape.add("Pentagon");

        }else {
        	shape.add("No Shapes Available");
        }
    return shape;
    }
} 
