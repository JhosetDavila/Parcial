DELIMITER $$ 
drop procedure if exists Generar_Multa;
create procedure Generar_Multa(
    DNI int,Multa varchar(30),Monto int,Correo varchar(30)
)
begin
    insert into Multa values(DNI,Multa,Monto,Correo)
END$$
DELIMITER ;