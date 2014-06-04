<%@ page language='java' contentType='text/html; charset=ISO-8859-1' pageEncoding='ISO-8859-1' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html class="no-js" lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SCK Cobranza</title>
    <link rel="stylesheet" href="css/foundation.css" />
    <script src="js/vendor/modernizr.js"></script>
</head>
<body>

<div>
    <nav class="top-bar" data-topbar>
        <ul class="title-area">
            <li class="name">
                <h1><a href="#">Pantalla Inicial</a></h1>
            </li>
        </ul>

        <section class="top-bar-section">
            <ul class="left">
                <li><a href="#">Despacho</a></li>
            </ul>
            <ul class="left">
                <li><a href="#">Gesti�n</a></li>
            </ul>
            <ul class="left">
                <li><a href="#">Contingencias</a></li>
            </ul>
            <ul class="left">
                <li><a href="#">Email a clientes</a></li>
            </ul>
            <ul class="left">
                <li><a href="#">Informes</a></li>
            </ul>
            <ul class="left">
                <li><a href="#">Administraci�n</a></li>
            </ul>
        </section>
    </nav>

</div>

    <div id="cuerpo">
        <div class="row" data-equalizer>
            <div style="height: 100px;padding-top:53px;">
                <fieldset style="float:left;">
                    <label>RUT :1-9</label>
                    <label>Raz�n Social : Cliente 1 </label>
                    <label>Email empresa : empresa@gmail.com</label>
                    <label>Clasificaci�n de riesgo : 4 </label>
                    <label>Pedidos en progreso : 4 </label>
                    <label>Tipo Seguro : 123</label>
                    <label>Vigencia : enero</label>
                    <label>Estado Cliente : DESBLOQ</label>
                    <label>Estado linea : DESBLOQ</label>
                </fieldset>
            </div>
            <div class="large-7 columns">
                <fieldset>
                    <label>Total Deuda : $000.000.000</label>
                    <table style="padding-top: 5px;">
                        <tr>
                            <th>Al d�a</th>
                            <th>1-30 d�as</th>
                            <th>31-50 d�as</th>
                            <th>61-90 d�as</th>
                            <th>< 90 d�as</th>
                        </tr>
                        <tr>
                            <td>$000.000</td>
                            <td>$000.000</td>
                            <td>$000.000</td>
                            <td>$000.000</td>
                            <td>$000.000</td>
                        </tr>
                    </table>
                </fieldset>
            </div>
        </div>
    </div>
    <fieldset>
        <legend>CONTACTOS COBRANZA</legend>
        <div style="text-align: right;">
            <a href="http://zurb.com/university/responsive-design" class="button secondary">Llamar</a>
        </div>
        <div style="padding-left:15px;padding-left: 15px;">
            <table style="width: 100%">
                <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Tel�fono</th>
                    <th>Email</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Content Goes Here</td>
                    <td>This is longer cont</td>
                    <td>Content Goes Here</td>
                </tr>
                <tr>
                    <td>Content Goes Here</td>
                    <td>This is longer Co</td>
                    <td>Content Goes Here</td>
                </tr>
                <tr>
                    <td>Content Goes Here</td>
                    <td>Content Goes Here</td>
                    <td>Content Goes Here</td>
                </tr>
                </tbody>
            </table>
        </div>
    </fieldset>

    <div style="padding-left:15px;padding-left: 15px;padding-right: 15px;width: 100%;">
        <a href="#" class="button secondary" data-reveal-id="validar">Validar</a>
        <a href="#" class="button secondary" data-reveal-id="agendar">Agendar</a>
        <a href="#" class="button secondary" data-reveal-id="recaudar">Recaudar</a>
        <a href="#" class="button secondary" data-reveal-id="contingencia">Contingencia</a>
        <a href="#" class="button secondary" data-reveal-id="bitacora">Bitacora</a>
        <a href="#" class="button secondary" data-reveal-id="hitos">Hitos</a>
        <a href="#" class="button secondary" data-reveal-id="email">Email</a>
        <a href="#" class="button secondary" >Enviar Docs.</a>
    </div>

    <div id="cuerpo_inferior" style="padding-top: 10px;">
            <div style="padding-left:15px;padding-left: 15px;padding-right: 15px;">
                <table style="width: 100%">
                    <thead>
                    <tr>
                        <th></th>
                        <th>N� Documento</th>
                        <th>Tipo</th>
                        <th>Monto Factura</th>
                        <th>Fecha Emisi�n</th>
                        <th>Fecha Vcto.</th>
                        <th>D�as Vencido</th>
                        <th>Vendedor</th>
                        <th>Tramo</th>
                        <th>Estado</th>
                        <th>Acci�n</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td style="text-align: center"><input type="checkbox" /></td>
                        <td>Content Goes Here</td>
                        <td>This is longer cont</td>
                        <td>Content Goes Here</td>
                        <td>Content Goes Here</td>
                        <td>Content Goes Here</td>
                        <td>Content Goes Here</td>
                        <td>Content Goes Here</td>
                        <td>This is longer cont</td>
                        <td>Content Goes Here</td>
                        <td>Content Goes Here</td>
                    </tr>
                    <tr>
                        <td style="text-align: center"><input type="checkbox" /></td>
                        <td>Content Goes Here</td>
                        <td>This is longer cont</td>
                        <td>Content Goes Here</td>
                        <td>Content Goes Here</td>
                        <td>Content Goes Here</td>
                        <td>Content Goes Here</td>
                        <td>Content Goes Here</td>
                        <td>This is longer cont</td>
                        <td>Content Goes Here</td>
                        <td>Content Goes Here</td>
                    </tr>
                    <tr>
                        <td style="text-align: center"><input type="checkbox" /></td>
                        <td>Content Goes Here</td>
                        <td>This is longer cont</td>
                        <td>Content Goes Here</td>
                        <td>Content Goes Here</td>
                        <td>Content Goes Here</td>
                        <td>Content Goes Here</td>
                        <td>Content Goes Here</td>
                        <td>This is longer cont</td>
                        <td>Content Goes Here</td>
                        <td>Content Goes Here</td>
                    </tr>
                    </tbody>
                </table>
            </div>
    </div>

    <div id="validar" class="reveal-modal" data-reveal>
        <fieldset>
            <legend>VALIDACI�N</legend>
            <div class="row" data-equalizer>
                <div class="large-5 columns">
                    <label>Observaci�n</label><br>
                    <textarea></textarea><br>
                    <label>Contacto</label><br>
                    <input type="text" />
                    <label>Cargo</label>
                    <input type="text" />
                </div>
                <div class="large-6 columns">
                    <label>Documentos Seleccionados</label>
                    <table style="padding-top: 5px;overflow-x: auto">
                        <tr>
                            <th>Al d�a</th>
                            <th>1-30 d�as</th>
                            <th>31-50 d�as</th>
                            <th>61-90 d�as</th>
                            <th>< 90 d�as</th>
                        </tr>
                        <tr>
                            <td>$000.000</td>
                            <td>$000.000</td>
                            <td>$000.000</td>
                            <td>$000.000</td>
                            <td>$000.000</td>
                        </tr>
                    </table>
                    <div style="text-align: right;">
                        <a href="#" class="button [tiny small large]"  >Aceptar</a>
                        <a href="#" class="button [tiny small large]" >Cancelar</a>
                    </div>
                </div>
            </div>
        </fieldset>
    </div>

    <div id="agendar" class="reveal-modal" data-reveal>
        <fieldset>
            <legend>AGENDA</legend>
            <div class="row" data-equalizer>
                <div class="large-5 columns">
                    <label>Fecha Agenda</label>
                    <select style="width: 50px;padding-right: 5px">
                        <option>dd</option>
                    </select >
                    <select style="width: 50px;padding-right: 5px">
                        <option>mm</option>
                    </select>
                    <select style="width: 50px;padding-right: 5px">
                        <option>yyyy</option>
                    </select>
                    <label>Hora Agenda</label>
                    <select style="width: 50px;padding-right: 5px">
                        <option>HH</option>
                    </select>
                    <select style="width: 50px;padding-right: 5px">
                        <option>MM</option>
                    </select><br>
                    Observaci�n
                    <textarea></textarea><br>
                    Contacto
                    <input type="text" /><br>
                    Cargo
                    <input type="text" />
                </div>
                <div class="large-6 columns">
                    <label>Documentos Seleccionados</label>
                    <table style="padding-top: 5px;overflow-x: auto">
                        <tr>
                            <th>Al d�a</th>
                            <th>1-30 d�as</th>
                            <th>31-50 d�as</th>
                            <th>61-90 d�as</th>
                            <th>< 90 d�as</th>
                        </tr>
                        <tr>
                            <td>$000.000</td>
                            <td>$000.000</td>
                            <td>$000.000</td>
                            <td>$000.000</td>
                            <td>$000.000</td>
                        </tr>
                    </table>
                    <div style="text-align: right;">
                        <a href="#" class="button [tiny small large]"  >Aceptar</a>
                        <a href="#" class="button [tiny small large]" >Cancelar</a>
                    </div>
                </div>
            </div>
        </fieldset>
    </div>

    <div id="recaudar" class="reveal-modal" data-reveal>
        <fieldset>
            <legend>AGENDA</legend>
            <div class="row" data-equalizer>
                <div class="large-6 columns">
                    <label>Forma de pago</label>
                    <select style="padding-right: 5px">
                        <option>Seleccione Forma de pago</option>
                    </select><br>
                    <label>Direcci�n</label>
                    <input type="text" /><br>
                    <input type="checkbox" />
                    Entrega Copia Cedible<br>
                    <label>Banco</label>
                    <input type="text" /><br>
                    <div style="float:left;">
                        <label>Sucursal Kupfer</label>
                        <input type="text" style="padding-right: 10px;width: 180px;"/>
                        <label>Contacto</label>
                        <input type="text" style="width: 180px;padding-right: 10px;"/>
                    </div>
                    <div style="float:right;">
                        <label>Sucursal Cliente</label>
                        <input type="text" style="width: 180px;"/>
                        <label>Cargo</label>
                        <input type="text" style="width: 180px;" />
                    </div>
                </div>
                <div class="large-6 columns">
                    <fieldset>
                        <legend>D�a pago Cliente</legend>
                        <input type="checkbox" />
                        <label style="padding-right: 5px;">Lunes</label>
                        <input type="checkbox" />
                        <label style="padding-right: 5px;">Martes</label>
                        <input type="checkbox" />
                        <label style="padding-right: 5px;">Miercoles</label>
                        <input type="checkbox" />
                        <label style="padding-right: 5px;">Jueves</label>
                        <input type="checkbox" />
                        <label style="padding-right: 5px;">Viernes</label>
                    </fieldset>
                    <div>
                        <label>Fecha Agenda</label><br>
                        <select style="width: 50px;padding-right: 5px">
                            <option>dd</option>
                        </select >
                        <select style="width: 50px;padding-right: 5px">
                            <option>mm</option>
                        </select>
                        <select style="width: 50px;padding-right: 5px">
                            <option>yyyy</option>
                        </select>
                        <label>Horario</label>
                        <input type="text" />
                    </div>
                    <div style="text-align: right;">
                        <a href="#" class="button [tiny small large]"  >Aceptar</a>
                        <a href="#" class="button [tiny small large]" >Cancelar</a>
                    </div>
                </div>
            </div>
        </fieldset>
    </div>

    <div id="contingencia" class="reveal-modal" data-reveal>
        <fieldset>
            <legend>CONTINGENCIA</legend>
            <div class="row" data-equalizer>
                <div class="large-5 columns">
                    Tipo Contingencia
                    <select style="width: 210px;padding-right: 5px">
                        <option>dd</option>
                    </select ><br>
                    <label>Observaci�n</label>
                    <textarea rows="7">

                    </textarea><br>
                    <label>Contacto</label>
                    <input type="text" /><br>
                    <label>Cargo</label>
                    <input type="text" /><br>
                </div>
                <div class="large-6 columns">
                    <label>Documentos Seleccionados</label>
                    <table style="padding-top: 5px;overflow-x: auto">
                        <tr>
                            <th>Al d�a</th>
                            <th>1-30 d�as</th>
                            <th>31-50 d�as</th>
                            <th>61-90 d�as</th>
                            <th>< 90 d�as</th>
                        </tr>
                        <tr>
                            <td>$000.000</td>
                            <td>$000.000</td>
                            <td>$000.000</td>
                            <td>$000.000</td>
                            <td>$000.000</td>
                        </tr>
                    </table>
                    <div style="text-align: right;">
                        <a href="#" class="button [tiny small large]"  >Aceptar</a>
                        <a href="#" class="button [tiny small large]" >Cancelar</a>
                    </div>
                </div>
            </div>
        </fieldset>
    </div>

    <div id="bitacora" class="reveal-modal" data-reveal>

    </div>

    <script src="js/vendor/jquery.js"></script>
    <script src="js/foundation.min.js"></script>
    <script>
        $(document).foundation();
    </script>
</body>
</html>