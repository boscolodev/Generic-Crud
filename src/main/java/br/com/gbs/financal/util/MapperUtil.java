package br.com.gbs.financal.util;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class MapperUtil {
    private static ModelMapper mapper = null;

    private MapperUtil() {
    }

    private static ModelMapper getMapper() {
        if (mapper == null) {
            mapper = new ModelMapper();
        }
        return mapper;
    }

    public static <T> T converte(Object origin, Class<T> destiny) {
        return MapperUtil.getMapper().map(origin, destiny);
    }

    public static void copyEntity(Object origin, Object destiny) {
        MapperUtil.getMapper().map(origin, destiny);
    }

    public static List<?> copyList(List<?>origin, List<?> destiny){
        List<?> result = destiny;
        MapperUtil.copyEntity(origin, result);
        return result;
    }

}
