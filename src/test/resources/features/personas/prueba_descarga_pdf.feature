# language: es
@personas
Característica: Banca de personas de Banistmo
  Como visitante del sitio
  Quiero entrar a aprender es facil, descubrir mas en legales, descubrir mas en Autocertificación fiscal FATCA & CRS
  Descargar el pdf de PJ-Autocertificación unificado - Fatca y CRS
  Validar que el descargado sea el correcto

  @smoke
  Escenario: Consultar la página de personas
    Dado que Jonnathan abre la banca de personas
    Cuando la pagina carga se sigue la ruta hasta autocertificacion fiscal

