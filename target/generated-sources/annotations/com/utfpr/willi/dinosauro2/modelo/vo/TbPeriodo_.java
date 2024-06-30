package com.utfpr.willi.dinosauro2.modelo.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbPeriodo.class)
public abstract class TbPeriodo_ {

	public static volatile SingularAttribute<TbPeriodo, String> evento_final;
	public static volatile SingularAttribute<TbPeriodo, Integer> inicio;
	public static volatile SingularAttribute<TbPeriodo, String> nome;
	public static volatile SingularAttribute<TbPeriodo, Long> id;
	public static volatile SingularAttribute<TbPeriodo, Integer> fim;
	public static volatile ListAttribute<TbPeriodo, TbTaxonomia> taxonomia;

}

