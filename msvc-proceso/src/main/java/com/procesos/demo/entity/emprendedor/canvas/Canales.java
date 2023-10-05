
package com.procesos.demo.entity.emprendedor.canvas;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "canales")
@Data
public class Canales {
  @Field(targetType = FieldType.OBJECT_ID)
  private String id;
  private String informacion;
  private String evaluacion;
  private String compra;
  private String entrega;
  private String postVenta;

}
