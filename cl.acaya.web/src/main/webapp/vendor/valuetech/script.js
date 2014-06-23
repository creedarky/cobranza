var dwDocWindow=null;

function OpenDocument(url, Folio, Rut, TipoDocumento, width,  height)
	{
	 //close old window
	 if (dwDocWindow)
		if (!dwDocWindow.closed)
			dwDocWindow.close();
	 if (width==0) {width = screen.width};
	 if (height==0) {height= screen.height};
	
	 var x="";
	 var y="";
	 
	
	 dwDocWindow= window.open('', "DocWindow", "dependent=yes,width="+width+",height="+height+",scrollbars,resizable=false"+x+y);

	 x = "left:" +  width / 2; 
	 y = "top:"  +  height / 2;
	 dwDocWindow.document.writeln('<html>');
	 dwDocWindow.document.writeln('<head>');
	 dwDocWindow.document.writeln('<title>Documento</title>'); 
	 
	 dwDocWindow.document.writeln('</head>');
	 
	 dwDocWindow.document.writeln('<body STYLE="color:white; filter: progid:dximagetransform.microsoft.gradient(gradienttype=0, startcolorstr= #101C63, endcolorstr= #FFFFFF;)">');
	 dwDocWindow.document.writeln('<p>Cargando documento...</p>');
	 dwDocWindow.document.writeln('<FORM Name="DocWnd" METHOD="POST" ACTION="' + url + '">')
	 dwDocWindow.document.writeln('<INPUT TYPE=HIDDEN NAME="COMMAND" VALUE="1">')
	 dwDocWindow.document.writeln('<INPUT TYPE=HIDDEN NAME="SESSIONID" VALUE="0">')
	 dwDocWindow.document.writeln('<INPUT TYPE=HIDDEN NAME="NAME" VALUE="usrkupfer">')
	 dwDocWindow.document.writeln('<INPUT TYPE=HIDDEN NAME="PASSWORD" VALUE="kupfer3267">')
	 dwDocWindow.document.writeln('<INPUT TYPE=HIDDEN NAME="JSENABLED" VALUE="1">')
	 dwDocWindow.document.writeln('<INPUT TYPE=HIDDEN NAME="LANGUAGE" VALUE="5">')
	 dwDocWindow.document.writeln('<INPUT TYPE=HIDDEN NAME="ARCHIVE" VALUE="KUPFER-Documentos Comerciales">')
	 dwDocWindow.document.writeln('<INPUT TYPE=HIDDEN Name="DIRECT" Value="TRUE">')
	 dwDocWindow.document.writeln('<INPUT TYPE=HIDDEN Name="Folio" Value="' + Folio + '">')
	 dwDocWindow.document.writeln('<INPUT TYPE=HIDDEN Name="Rut" Value="' + Rut + '">')
	 dwDocWindow.document.writeln('<INPUT TYPE=HIDDEN Name="TipoDocumento" Value="' + TipoDocumento + '">')
	 dwDocWindow.document.writeln('</form>')
	 dwDocWindow.document.writeln('<script language="javascript">DocWnd.submit();</script>');
	 dwDocWindow.document.writeln('</body>'); 
	 dwDocWindow.document.writeln('</html>');
	 dwDocWindow.document.close();
	 dwDocWindow.focus();
}
