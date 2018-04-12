package by.it.sgolovach.jd01_09;

abstract class Patterns {

    static final String OPERATION = "[-+*/]";
    static final String SCALAR = "-?[0-9]+\\.?[0-90]*";
    static final String VECTOR = "\\{((-?[0-9]+\\.?[0-90]*),?)+}";
    static final String MATRIX = "\\{(\\{((-?[0-9]+\\.?[0-90]*),?)+},?)+}";

}