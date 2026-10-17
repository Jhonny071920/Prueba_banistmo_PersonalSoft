# language: es
@personas
Característica: Banca de personas de Banistmo
  Como visitante del sitio
  Quiero abrir la banca de personas
  Para consultar la oferta del banco

  @smoke
  Escenario: Consultar la página de personas
    Dado que Camila abre la banca de personas
    Entonces debería ver el sitio de Banistmo
