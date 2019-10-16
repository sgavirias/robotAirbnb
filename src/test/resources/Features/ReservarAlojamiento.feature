@ReservarAlojamiento
Feature: reservar alojamiento
  As
    usuario no registrado
  I want
    reservar alojamiento para 3 personas

  @BuscarReserva
  Scenario: reservar alojamiento
    Given que me encuentro en el sitio de airbnb
    When completo los campos del formulario
    Then obtengo reporte de check in

