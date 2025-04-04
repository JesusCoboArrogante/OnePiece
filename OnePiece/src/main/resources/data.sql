DELETE FROM  personajeOnePiece;

ALTER TABLE personajeOnePiece
    ALTER COLUMN  id RESTART WITH 1;

INSERT INTO personajeOnePiece(nombre,apodo,haki,fruta,vivo,activo,createAt,LocalDateTime,recompensa,tripulacion,Rango)
    VALUES ('kuma', 'el tirano', true,true,true,true,'2024-03-20 20:30:24.352127', '2024-03-20 20:30:24.369123',296.000.000,'armada revolucionada', 'shichibukai')