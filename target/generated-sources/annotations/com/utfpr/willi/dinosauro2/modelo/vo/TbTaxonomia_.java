package com.utfpr.willi.dinosauro2.modelo.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbTaxonomia.class)
public abstract class TbTaxonomia_ {

	public static volatile SingularAttribute<TbTaxonomia, TbEspecie> especie;
	public static volatile ListAttribute<TbTaxonomia, TbPeriodo> periodo;
	public static volatile SingularAttribute<TbTaxonomia, String> nome;
	public static volatile ListAttribute<TbTaxonomia, TbLocomocao> tbLocomocao;
	public static volatile SingularAttribute<TbTaxonomia, Integer> id;

}

