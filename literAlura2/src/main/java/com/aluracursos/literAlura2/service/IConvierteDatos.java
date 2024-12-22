package com.aluracursos.literAlura2.service;

import java.util.List;

public interface IConvierteDatos {
    <T> T convert(String json, Class<T> tClass);

    <T> List<T> convertList(String json, Class<T> tClass);
}
