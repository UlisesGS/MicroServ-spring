package com.procesos.demo.entity.emprendedor.canvas;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "modelo_canvas")
@Data
public class Canvas {
    @Field(targetType = FieldType.OBJECT_ID)
    private String id;
    private ActividadClave actividadClave;
    private Canales canales;
    private EstructuraCosto estructuraCosto;
    private FlujoDeIngreso flujoDeIngreso;
    private PropuestaValor propuestaValor;
    private RecursoClave recursoClave;
    private RelacionCliente relacionCliente;
    private SegmentoCliente segmentoCliente;
    private SocioCLave socioCLave;
   /*
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @OneToOne
        private CustomerSegments customerSegments;
        @OneToOne
        private ValuePropositions valuePropositions;
        @OneToOne
        private Channels channels;
        @OneToOne
        private CustomerRelationships customerRelationships;
        @OneToOne
        private KeyRecources keyRecources;
        @OneToOne
        private KeyActivities keyActivities;
        @OneToOne
        private KeyPartners keyPartners;
        @OneToOne
        private RevenueStreams revenueStreams;
        @OneToOne
        private CostStructure costStructure;
        @OneToOne
        private Client client;

*/

}
