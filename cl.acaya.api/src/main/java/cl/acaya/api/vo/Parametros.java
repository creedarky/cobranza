
package cl.acaya.api.vo;

/**
 * @author Kiosolutions
 */
public interface Parametros {

    Long PRM_ID_FACTURA_ELECTRONICA = 9L;
    String AGENTES = "listaAgentes";
    String APODERADO_APELL_MATERNO = "apodApeMat";
    String APODERADO_APELL_PATERNO = "apodApePat";
    String APODERADO_NOMBRE = "apodNom";
    String APODERADO_RUT = "apodRut";
    String APODERADO_RUT_DV = "apodRutDv";
    String ATTR_AGENTE = "pcdcAgente";
    String ATTR_TIPO_NEGOCIO = "pcdcCodigoTipoNegocio";
    String ATTR_TIPO_UBICACION = "ubicacionDeNegocio";
    String ATTR_TIPO_NEGOCIO_SESSION = "pcdcCodigoTipoNegocioSession";
    String ATTR_AGENTES = "pcdcAgentes";
    String ATTR_BODEGA = "pcdcBodega";
    String ATTR_BODEGASSAP = "pcdcBodegasSAP";
    String ATTR_NUMERO_NEGOCIO = "pcdcNumeroNegocio";
    String ATTR_PUNTOS_VENTA = "pcdcPuntosVenta";
    String ATTR_PUNTO_VENTA = "pcdcPuntoVenta";
    String ATTR_RUT_CLIENTE_DV = "pcdcRutClienteDv";
    String ATTR_RUT_CLIENTE_SIN_DV = "pcdcRutClienteSinDv";
    String ATTR_VENDEDOR = "pcdcVendedor";
    String BODEGAS_SAP = "listaBodegasSAP";
    String CARRO_COMPRA_DETALLE_PREVIO = "carroCompraDetallePrevio";
    String CLIENTE = "rp_CLIENTE";
    String CLIENTE_ANTIGUO = "clienteAntiguo";
    String CLIENTE_CUENTA_NUMERO = "clntCtaNum";
    String CLIENTE_CUENTARP_NUMERO = "clntCtaRPNum";
    String CLIENTE_DATOS = "clienteDatos";
    String CLIENTE_GRUPO_CODIGO = "clntGrupoCodigo";
    String CLIENTE_GRUPO_DESC = "clntGrupoDesc";
    String CLIENTE_GRUPO_VO = "clntGrupoVO";
    String CLIENTE_RAZON_SOCIAL = "clntRazonSocial";
    String CLIENTE_REPRESENTANTES_LEGALES = "clienteRepresentantesLegales";
    String CLIENTE_RUT = "rutCliente";
    String CLIENTE_RUT_DV = "rutClienteDv";
    String CLIENTE_SEGMENTO_CODIGO = "clntSegmentoCodigo";
    String CLIENTE_SEGMENTO_DESC = "clntSegmentoDesc";
    String CLIENTE_SEGMENTO_VO = "clntSegmentoVO";
    String CLIENTE_TIPO_CODIGO = "clntTipoCodigo";
    String CLIENTE_TIPO_DESC = "clntTipoDesc";
    String CLIENTE_TIPO_VO = "clntTipoVO";
    String CODIGO_CLASIFICACION = "codigoClasificacion";
    String CODIGO_MENSAJE = "codigoMensaje";
    String CODIGO_SISTEMA = "codigoSistema";
    String NUMERO_SISTEMA = "numeroSistema";
    String CODIGO_TIPO_NEGOCIO = "codigoTipoNegocio";
    String CODI_VALOR1 = "codiValor1";
    String DATOSCLIENTE = "rp_DATOSCLIENTE";
    String DEFAULT_CODI_SISTEMA = "defCodiSistema";
    String DETALLE = "rp_DETALLE";
    String DETALLE_EQUIPO = "rp_DETALLE_EQUIPO";
    String DETALLE_MOVIL = "rp_DETALLE_MOVIL";
    String EQUIPOS = "rp_EQUIPOS";
    String EXCEPCIONADORES = "rp_EXCEPCIONADORES";
    String FIN_NEGOCIO = "rp_FIN_NEGOCIO";
    String GRABAR_EXCEPCIONADOR = "grabarExcepcionador";
    String ID_CONSULTA = "identificadorConsulta";
    String INDC_PREFIJO = "indcPrefijo";
    String INDC_PREFIJO1 = "indcPrefijo1";
    String RRLL_TIPO_ACCION = "indicadorConsulta";
    String MOTIVOS = "rp_MOTIVOS";
    String MOVILES = "rp_MOVILES";
    String MQ_DATA = "mqSeriesData";
    String MQ_INVOKE_URL = "mqInvokeURL";
    String MQ_NOM_RISTRA_HNDLR = "mqSeriesNomRistraHandler";
    String MQ_RESP = "rp_MQ_RESP";
    String NMRO_EVALUACION = "nmroEvaluacion";
    String NMRO_LINEAS_DISPONIBLES = "nmroLineasDisponibles";
    String NMRO_LINEAS_SOLICITADAS = "nmroLineasSolicitadas";
    String NMRO_MOVILES = "nmroMoviles";
    String NUMERO_NEGOCIO = "numeroNegocio";
    String PRM = "rp_PRM";
    String PRM_BODEGA = "bodega";
    String PRM_COD_COMPONENTE = "codigoComponente";
    String PRM_COD_CUENTA = "codigoCuenta";
    String PRM_COD_CUENTA_SUSCRIPTORA = "codigoCuentaSuscriptora";
    String PRM_COD_NEGOCIO = "codigoNegocio";
    String PRM_COD_USUARIO = "codUsuario";
    String PRM_CORRELATIVOTIPO = "correlativoTipo";
    String PRM_DVCLIENTE = "dvCliente";
    String PRM_DVVENDEDOR = "dvVendedor";
    String PRM_ENCABEZADO = "encabezado";
    String PRM_EQUIPO_ID = "idEquipo";
    String PRM_ESTADO = "estado";
    String PRM_ESTADO_FACTURACION = "estadoFacturacion";
    String PRM_FACTURA_ELECTRONICA = "facturaElectronica";
    String PRM_JSON = "json";
    String PRM_MOVIL_ID = "idMovil";
    String PRM_NUMNEGOCIO = "numeroNegocio";
    String PRM_PTOVENTA = "puntoVenta";
    String PRM_REN_MIG_VO = "renMigVO";
    String PRM_RUT = "rut";
    String PRM_RUTCLIENTE = "rutCliente";
    String PRM_RUTVENDEDOR = "rutVendedor";
    String PRM_SUBMOTIVO_ID = "submotivoId";
    String PRM_SUCVENDEDOR = "agente";
    String PRM_SUCVENDEDOR_DV = "agente_dv";
    String PRM_SUC_USUARIO = "sucUsuario";
    String PRM_SUC_VENTA = "sucVenta";
    String PRM_TIPO_NEGOCIO = "tipoNegocio";
    String PRM_USUARIO_SAU = "usuarioSAU";
    String RANGO_CANTIDAD = "rangoCantidad";
    String RANGO_DESDE = "rangoDesde";
    String RRLL_APELL_MATERNO = "rrllApeMat";
    String RRLL_APELL_PATERNO = "rrllApePat";
    String RRLL_CODIGO = "rrllCodigo";
    String RRLL_EMAIL = "eMailRepresentante";
    String RRLL_ESTADO_VIGENCIA_CODIGO = "codigoEstadoVigencia";
    String RRLL_ESTADO_VIGENCIA_DESC = "descEstadoVigencia";
    String RRLL_FECHA_ESCRIT_SOC_A = "rrllFechaEscritA";
    String RRLL_FECHA_ESCRIT_SOC_D = "rrllFechaEscritD";
    String RRLL_FECHA_ESCRIT_SOC_M = "rrllFechaEscritM";
    String RRLL_NOMBRE = "rrllNom";
    String RRLL_OBSERVACIONES = "rrllObs";
    String RRLL_RUT = "rrllRut";
    String RRLL_RUT_DV = "rrllRutDv";
    String RRLL_TELEFONO = "rrllTelef";
    String RRLL_TIPO_ACTUAR_CODIGO = "codigoTipoActuar";
    String RRLL_TIPO_ACTUAR_DESC = "descripcionTipoActuar";
    String RRLL_INDICADOR_CONSULTA = "indicadorConsulta";
    String RRLL_UPDATE = "updateRpll";
    String RUT = "rp_RUT";
    String RUT_CLIENTE_CON_DV = "rutClienteConDv";
    String SERIE_EQUIPO = "serieEquipo";
    String SISTEMA_FED = "rp_SISTEMA_FED";
    String SUBMOTIVOS = "rp_SUBMOTIVOS";
    String TRANSACCIONES = "rp_TRANSACCIONES";
    String VENDEDOR = "rp_VENDEDOR";
    String VENDEDOR_RUT = "rutVendedor";
    String VENDEDOR_RUT_DV = "rutDVVendedor";
    String ZONAS_PRIMARIAS = "rp_ZONAS_PRIMARIAS";
    String RUT_EXCEPCIONADOR = "rutExcepcionador";
    String EMAIL_EXCEPCIONADOR = "emailExcepcionador";
    String CELULAR_EXCEPCIONADOR = "celularExcepcionador";
    String CODIGO_EXCEPCIONADOR = "codigoExcepcionador";
    String DESCRIPCION_EXCEPCIONADOR = "descripcionExcepcionador";
    String SALDO_EXCEPCIONADOR = "saldoExcepcionador";
    String PRM_NUMERO_SERIE = "numeroSerie";
    String PRM_CUOTAS_PENDIENTES = "cuotasPendientes";
    String RRLL_MODIFICAR = "M";
    String RRLL_ELIMINAR = "E";
    String RRLL_AGREGAR = "A";
    String MODIFICAR = "M";
    String QUIEN_REALIZA_NEGOCIO = "quienRealizaNegocio";
    String CODIGO_RESPUESTA = "codigoRespuesta";
    String CODIGO_MANDATO = "codigoMandato";
    String CODIGO_INDICADOR = "codigoIndicador";
    String PRM_REQUIERE_FACTURACION_ELECTRONICA = "requiereFacturacionElectronica";
    String PRM_EMAIL = "email";
    String RISTRA_RESPONSE = "ristraResponse";
    String RISTRA_REQUEST = "ristraRequest";
    String WS_MQSERIES_URL = "wsMqSeriesUrl";
    String WS_MQSERIES_TIMEOUT = "wsMqSeriesTimeout";
    String CODIGO_PUNTO_VENTA = "codigoPuntoVenta";
    String USUARIO_RUT = "usuarioRut";
    String USUARIO_DV = "usuarioDv";
    String CODIGO_BODEGA = "codigoBodega";
    String PRM_CORRELATIVO_NEGOCIO = "correlativoNegocio";
    String PRM_ANULACION_SUBSCRIPCION = "anulacionSubscripcion";
    String ANULACIONES = "anulacion";
    String MOTIVOS_ANULACION = "motivosAnulacion";
    String INDC_OPCION = "indcOpcion";
    String PORC_DESCUENTO = "porcDescuento";
    String CODI_LINEA_NEGOCIO = "codiLineaNegocio";
    String CODI_OPERACION_COMERC = "codiOperacionComerc";
    String EXCEPCIONADOR_ANULACIONES = "excepcionadorAnulaciones";
    String PLAN_COMERCIAL = "planComercial";
    String DURACION_CONTRATO = "duracionContrato";
    String OPERACIONES_COMERCIALES = "operacionesComerciales";
    String OPERACIONES_COMERCIALES_SUSCRIPCION = "operacionesComercialesSuscripcion";
    String CODIGO_CANAL_PUNTO_VENTA = "codigoCanalPuntoVenta";
    String NUMERO_PCS = "numeroMovil";
    String VALOR_CLIENTE = "valorCliente";
    String TIPO_CAMBIO_EQUIPO = "tipoCambioEquipo";

    String TOTAL_LINEAS = "totalLineas";
    String TOTAL_EQUIPOS = "totalEquipos";
    String TOTAL_EQUIPOS_DIF = "totalEquiposDif";
    String SIN_TOPE = "SIN_TOPE";
    String LISTA_EXCEPCIONADORES_ANULACION = "listaExcepcionadoresAnulacion";
    String NUMERO_FOLIO = "numeroFolio";
    String CODIGO_DOCUMENTO = "codigoDocumento";
    String DIAS_HABILES_PERMITIDOS_ANULACION = "diasHabilesPermitidosAnulacion";

    String SYSTEM_STATUS = "systemStatus";
    String SERIES_EQUIPO = "seriesEquipo";
    String IP = "ip";
    String LINEA_NEGOCIO = "lineaDeNegocio";
    String CODIGO_VENDEDOR = "codigoVendedor";
    String CODIGO_SUCURSAL = "codigoSucursal";
    String PAGINA = "pagina";
    String USUARIO = "usuario";
    String RETRI_NUMERO_NEGOCIO = "recuperaNumeroDeNegocio";
    String EQUIPOS_SIZE = "equiposSize";
    String EQUIPOS_SIZE_SELECTED = "equiposSizeSelected";
    String MOVILES_SIZE = "movilesSize";
    String MOVILES_SIZE_SELECTED = "movilesSizeSelected";
    String PRM_QLINEAS_EQUIPOS = "qEquiposLineas";
    String CLIENTE_CUSTOMER_ID = "customerId";
    String NEGOCIO_FORM_DATA = "negocioData";
    String VALIDA_MOVIL = "validaMovil";
    String VALIDACION_MOVIL = "validacionMovil";
    String TIPO_NEGOCIO = "tipoNegocio";
    String RRLL_VIGENCIA_ACTUARES = "rrllVigenciaActuares";
    String CSTA_PEC = "cstaPec";
    String CUENTA_BSCS = "cuentaBscs";
    String TRAFICC_IMEI = "traficcImei";

    String MONTO_POR_PAGAR = "montoPorPagar";
    String DESCUENTO = "descuento";
    String CUOTAS_POR_PAGAR = "cuotasPorPagar";
    String CUOTA_OPCION_COMPRA = "cuotaOpcionCompra";

    String PRM_RUT_FIRMANTE = "rutFirmante";
    String PRM_RUT_FIRMANTE_DV = "rutFirmanteDv";
    
    /**
     * Descuento Cargo Fijo
     */
    String DESCUENTO_CARGO_FIJO_URL = "descuentoCargoFijoURL";
    String ACCIONAR_DESCUENTO_CARGO_FIJO = "accionarDescuentoCargoFijo";
    String CODIGO_CUENTA_BSCS = "codigoCuentaBSCS";
    String CODIGO_CUENTA_BSCS_SUSCRIPTORA = "codigoCuentaBSCSSuscriptora";
    String DESCRIPCION_MENSAJE_DESCUENTO_CARGO_FIJO = "descripcionMensajeDescuentoCargoFijo";

    /*Parametros para listas de equipos y moviles*/
    String EQUIPOS_MOVILES = "equiposMoviles";
    String NUMERO_NEGOCIO_ORIGINAL = "numeroNegocioOriginal";
    /*EQUIPO*/
    String MODELO_EQUIPO = "modeloEquipo";
    String COSTO_EQUIPO = "costoEquipo";
    String MARCA_EQUIPO = "marcaEquipo";
    String CODIGO_MARCA_EQUIPO = "codMarcaEquipo";
    String IS_SELECTED = "isSelected";
    String CHECK = "check";
    String FECHA_ACTUAL = "fechaActual";

    /*MOVIL*/
    String FECHA_ACTIVACION = "fechaActivacion";

    /**
     * MOTIVO
     */
    String PRM_MOTIVO = "motivo";
    String PRM_DES_MOTIVO = "descripcionMotivo";
    /**
     * SUB MOTIVO
     */
    String PRM_SUB_MOTIVO = "subMotivo";
    String PRM_DES_SUB_MOTIVO = "descripcionSubMotivo";
    /**
     * AREA
     */
    String PRM_AREA = "area";
    String PRM_DES_AREA = "descripcionArea";
    /**
     * TELEFONO
     */
    String PRM_TELEFONO = "telefono";
    String EQUIPOS_RESUMEN = "equiposResumen";
    String EQUIPOS_BASE = "equiposBase";

    String CODIGO_CARGO = "codigoCargo";
    String PRM_NUMERO = "numero";
    String NEGOCIO_ORIGINAL = "negocioOriginal";
    String NEGOCIOS_ORIGINALES = "negociosOriginales";
    /**
     * EQUIPOS ANULACION
     */
    String EQUIPOS_ANULACION = "equiposAnulacion";
    String EQUIPOS_ANULACION_SELECCIONADOS = "equiposAnulacionSeleccionados";
    String EQUIPOS_SALIDA = "equiposSalida";
    String EQUIPO_ABIERTO = "abierto";
    String EQUIPO_SALIDA = "equipoSalida";
    String CODIGO_PRODUCTO = "codigoProducto";
    String FECHA_NEGOCIO_ORIGINAL = "fechaNegocioOriginal";
    String PRECIO_EQUIPO_ANULAR = "precioEquipoAnular";

    /**
     * LINEA ANULACION
     */
    String LINEA_ANULAR = "lineaAnular";
    String PRM_IMEI = "imei";
    String PRM_IMSI = "imsi";
    String PRM_ICCID = "iccid";

    String NUMERO_ANULAR = "numeroAnular";
    String SALDO_INICIAL = "saldoInicial";
    String SALDO_ACTUAL = "saldoActual";
    String PORCENTAJE_SALDO = "porcentajeSaldo";

    /**
     * Equipo salida
     */
    String CODIGO_BARRA = "codigoBarras";
    String DESCRIPCION_EQUIPO_SALIDA = "descripcionEquipoSalida";
    String OPERACION_COMERCIAL = "operacionComercial";
    String CODIGO_DURACION_CONTRATO = "codigoDuracionContrato";
    String CANTIDAD_EQUIPOS_SALIDA = "cantidadEquipoSalida";
    String PRECIO_UNITARIO_EQUIPO_SALIDA = "precioUnitarioEquipoSalida";
    String PRECIO_TOTAL_EQUIPO_SALIDA = "precioTotalEquipoSalida";
    String CODIGO_CANAL = "codigoCanal";
    String RRLL_FECHA_ESCRITURA = "fechaEscritura";
    String MOSTRAR_CESION_TRASPASO = "mostrarCesionTraspaso";
    String EXPOSE_ACEPTAR_CESION_TRASPASO = "exposeAceptarCesionTraspaso";
    String EXPOSE_CANCELAR_CESION_TRASPASO = "exposeCancelarCesionTraspaso";
    String CODIGO_IMPLICITO = "codigoImplicito";
    String CODIGO_EXPLICITO = "codigoExplicito";

    String CODIGO_MOTIVO_ANULACION = "codigoMotivoAnulacion";
    String CONSULTA_TARJETAS_ANULADAS = "consultaTarjetasAnuladas";

    /**
     * Retoma Negocio
     */
    String PRM_RETOMA_NEGOCIO = "retomaNegocio";
    String NEGOCIOS_PENDIENTES = "negociosPendientes";


    /**
     * Mock
     */

    double PRM_IVA = 1.19;

    /**
     * Valida Devolucion
     */
    String VALIDA_DEVOLUCION = "validaDevolucion";
    String PRM_COD_PRODUCTO = "codigoProducto";
    String PRM_DEVOLUCION_0000S =  "0000S";
    String PRM_DEVOLUCION_0000N =  "0000N";
    String EQUIPO_COD_PRODUCTO = "equiposCodProducto";
    String PRM_DEVOLUCION_0001 = "0001";

    /*Negocio Previo*/
    String TIENE_NEGOCIO_PREVIO = "tieneNegocioPrevio";

    /**
     * DESCUADRE
     */
    String DESCUADRE = "descuadre";

    /**
     * Validaciones Anulacion
     */
    String CODIGO_PLAN_POS = "codigoPlanPos";
    String CODIGO_PLAN = "codigoPlan";
    String CODIGO_EQUIPO = "codigoEquipo";
    String CODIGO_TIPO_NEGOCIO_POS = "codigoTipoNegocioPos";
    String NUMERO_CORRELATIVO_NEGOCIO = "numeroCorrelativoNegocio";
    String NUMERO_CORRELATIVO_PRODUCTO = "numeroCorrelativoProducto";
    String CODIGO_DCTO_VENTA = "codigoDocumentoVenta";
    String NUMERO_DCTO_VENTA = "numeroDocumentoVenta";

    String TIPO_DOCUMENTO = "tipoDocumento";
    String NUMERO_TRANSACCION = "numeroTransaccion";
    String DESCRIPCION_MENSAJE = "descripcionMensaje";
    String CANTIDAD_EQUIPOS_ARRIENDO = "cantidadEquiposArriendo";
    String CANTIDAD_LINEAS = "cantidadLineas";
    String DUPLICIDAD_EQUIPO = "duplicidadEquipo";
    String DUPLICIDAD_CODIGO_PRODUCTO = "duplicidadCodigoProducto";
    String ANTIGUEDAD_LINEA = "antiguedadLinea";

    String AUTORIZADOR = "autorizador";
    String CESION_TRASPASO = "idCesionTraspaso";
    String HABILITACION_NEGOCIO_TOTALMENTE_ANULADO = "habilitaNegocioTotalmenteAnulado";

    String DETALLE_CUENTARP = "detalleCuentaRP";

    String VALIDA_EQUIPO_LINEA_EXISTENCIA_NEGOCIO = "validaExistenciaLineaEquipo";
    String LISTA_EQUIPOS="listaEquipos";
    String LISTA_LINEAS="listaLineas";

    //Anulacion Sin Suscripcion
    String PROMOCIONES = "promociones";

    //PORTABILIDAD
    String CODIGO_SOLPO="codigoSolpo";
    String SOLICITUDES_PORTABILIDAD ="solicitudesPortabildiad";

    String LISTA_NEGOCIOS = "listaNegocios";
    String EXISTE_NEGOCIO = "existeNegocio";
}
