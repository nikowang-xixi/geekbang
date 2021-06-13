create table emall_goods
(
	id bigint auto_increment comment '主键'
		primary key,
	gmt_create timestamp null comment '创建时间',
	creator bigint null comment '创建该数据的用户 Id',
	gmt_modified timestamp null comment '最近一次的修改时间',
	modifier bigint null comment '修改的人的 id',
	is_deleted varchar(1) charset utf8 default 'N' null comment '是否删除标记',
	spu_id bigint null comment 'spuId',
	is_on_sale varchar(1) charset utf8 null comment '是否上架 Y：是 N：否',
	goods_price decimal null comment '商品单价',
	goods_img varchar(255) charset utf8 null comment '商品图片',
	goods_sn varchar(16) charset utf8 null comment '商品编码'
)
comment '商品表' charset=utf8mb4;

create table emall_order
(
	id bigint auto_increment
		primary key,
	gmt_create timestamp null comment '创建时间',
	creator bigint null comment '创建该数据的用户 Id',
	gmt_modified timestamp null comment '最近一次的修改时间',
	modifier bigint null comment '修改的人的 id',
	country_id bigint null comment '下单地址——国家',
	province_id bigint null comment '下单地址--省',
	city_id bigint null comment '下单地址--城市',
	district_id bigint null comment '下单地址--区',
	street_id bigint null comment '下单地址--街道',
	address varchar(128) charset utf8 null comment '详细收获地址',
	order_amount decimal null comment '订单金额',
	ship_fee decimal null comment '物流费用',
	remark varchar(256) charset utf8 null comment '订单备注',
	order_sn varchar(64) charset utf8 null comment '订单编码',
	store_id varchar(16) charset utf8 null comment '在哪个店铺下单',
	order_status varchar(64) charset utf8 null comment '订单状态',
	shipping_status varchar(64) charset utf8 null comment '物流状态',
	is_deleted varchar(1) charset utf8 default 'N' null comment '是否删除标记'
)
comment '订单表' charset=utf8mb4;

create table emall_order_goods
(
	id bigint auto_increment
		primary key,
	gmt_create timestamp null comment '创建时间',
	creator bigint null comment '创建该数据的用户 Id',
	gmt_modified timestamp null comment '最近一次的修改时间',
	modifier bigint null comment '修改的人的 id',
	order_id bigint null comment '订单 ID',
	goods_id bigint null comment '商品 id',
	goods_number int null comment '下单商品数量',
	sales_amount decimal null comment '售卖价格',
	ori_price decimal null comment '商品单价',
	snapshot json null comment '商品快照 JSON形式',
	spu_id bigint null comment 'SPUID',
	is_deleted varchar(1) charset utf8 default 'N' null comment '是否删除标记'
)
comment '订单商品表' charset=utf8mb4;

create table emall_spu
(
	id bigint auto_increment comment '主键'
		primary key,
	gmt_create timestamp null comment '创建时间',
	creator bigint null comment '创建该数据的用户 Id',
	gmt_modified timestamp null comment '最近一次的修改时间',
	modifier bigint null comment '修改的人的 id',
	spu_sn varchar(32) charset utf8 null comment 'spu编码',
	brand_id bigint null comment '品牌 ID',
	store_id bigint null comment '店铺 ID',
	cat_id bigint null comment '品类 id
',
	unit varchar(16) charset utf8 null comment '商品单位',
	goods_desc varchar(255) charset utf8 null comment '商品描述',
	remark varchar(256) charset utf8 null comment '备注',
	is_deleted varchar(1) charset utf8 default 'N' null comment '是否删除标记'
)
comment 'SPU 信息表' charset=utf8mb4;

create table emall_store
(
	id bigint auto_increment
		primary key,
	gmt_create timestamp null comment '创建时间',
	creator bigint null comment '创建该数据的用户 Id',
	gmt_modified timestamp null comment '最近一次的修改时间',
	modifier bigint null comment '修改的人的 id',
	is_deleted varchar(1) charset utf8 default 'N' null comment '是否删除标记',
	user_id bigint null comment 'store 关联的用户 Id',
	store_name varchar(64) charset utf8 null comment '店铺名称',
	store_nick_name varchar(64) charset utf8 null comment '店铺昵称',
	contact_name varchar(64) charset utf8 null comment '联系人姓名',
	contact_mobile varchar(11) charset utf8 null comment '联系人手机号',
	biz_brand varchar(128) charset utf8 null comment '店铺主营品牌',
	biz_cat varchar(128) charset utf8 null comment '店铺经营分类',
	store_province_id bigint null comment '店铺所在省份 id',
	store_city_id bigint null comment '店铺所在城市 Id',
	store_district_id bigint null comment '店铺所在区 id
',
	store_street_id bigint null comment '店铺所在街道 id',
	store_address varchar(125) charset utf8 null comment '店铺详细地址',
	business_time_begin varchar(64) charset utf8 null comment '营业时间-开始',
	business_time_end varchar(64) charset utf8 null comment '营业时间-结束'
)
comment '店铺表' charset=utf8mb4;

create table emall_user
(
	id bigint not null comment 'id '
		primary key,
	gmt_create timestamp null comment '创建时间',
	creator bigint null comment '创建该数据的用户 Id',
	gmt_modified timestamp null comment '最近一次的修改时间',
	modifier bigint null comment '修改的人的 id',
	is_deleted varchar(1) charset utf8 default 'N' null comment '是否删除标记',
	nick_name varchar(32) charset utf8 null,
	password varchar(125) charset utf8 not null,
	email varchar(255) charset utf8 null comment 'email',
	mobile varchar(11) charset utf8 not null comment '手机号码',
	user_name varchar(32) charset utf8 not null comment '用户名'
)
charset=utf8mb4;

