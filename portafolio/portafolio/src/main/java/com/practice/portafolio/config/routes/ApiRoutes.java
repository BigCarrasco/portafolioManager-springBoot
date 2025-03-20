package com.practice.portafolio.config.routes;

public class ApiRoutes {
    public static final String BASE_API = "/api";

    public static final String PORTAFOLIO = BASE_API + "/portafolio";
    public static final String PORTAFOLIO_BY_ID = PORTAFOLIO + "/{id}";

    public static final String CREATE_PORTAFOLIO = PORTAFOLIO;        // POST /api/portafolio
    public static final String GET_ALL_PORTAFOLIO = PORTAFOLIO;
    public static final String GET_PORTAFOLIO_BY_ID = PORTAFOLIO_BY_ID; // GET /api/portafolio/{id}
    public static final String UPDATE_PORTAFOLIO = PORTAFOLIO_BY_ID;
    public static final String DELETE_PORTAFOLIO = PORTAFOLIO_BY_ID;
}
