package com.utfpr.willi.dinosauro2.modelo.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbEspecie.class)
public abstract class TbEspecie_ {

	public static volatile SingularAttribute<TbEspecie, Double> tamanho_medio;
	public static volatile SingularAttribute<TbEspecie, String> alimentacao;
	public static volatile SingularAttribute<TbEspecie, Double> peso_medio;
	public static volatile SingularAttribute<TbEspecie, Boolean> esqueleto_completo;
	public static volatile ListAttribute<TbEspecie, TbHabitat> habitat;
	public static volatile SingularAttribute<TbEspecie, String> data_descoberta;
	public static volatile SingularAttribute<TbEspecie, String> nome;
	public static volatile SingularAttribute<TbEspecie, Long> id;
	public static volatile ListAttribute<TbEspecie, TbTaxonomia> taxonomia;

}

