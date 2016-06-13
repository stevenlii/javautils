select ORDERSTATE,count(*) a from UMPAY.T_UPORDER_1411 group by ORDERSTATE

select prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME,SUM(prim.AMOUNT) TOTALAMOUNT from (select t.*,bank.BANKNAME,goods.GOODSNAME,mer.MERNAME from UMPAY.T_UPTRANS_1411 as t left join UMPAY.T_BANK_INF as bank on bank.BANKID=t.BANKID left join UMPAY.T_GOODS_INF goods on goods.GOODSID=t.GOODSID and goods.MERID=t.MERID left join UMPAY.T_MER_INF as mer on t.MERID=mer.MERID) prim group by prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME

select prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME,prim.ORDERSTATE,COUNT(prim.ORDERSTATE) ORDERCOUNT from (select t.*,bank.BANKNAME,goods.GOODSNAME,mer.MERNAME from UMPAY.T_UPORDER_1411 as t left join UMPAY.T_BANK_INF as bank on bank.BANKID=t.BANKID left join UMPAY.T_GOODS_INF goods on goods.GOODSID=t.GOODSID and goods.MERID=t.MERID left join UMPAY.T_MER_INF as mer on t.MERID=mer.MERID) prim group by prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME,prim.ORDERSTATE

select prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME,COUNT(prim.ORDERSTATE) ORDERCOUNT from (select t.*,bank.BANKNAME,goods.GOODSNAME,mer.MERNAME from UMPAY.T_UPORDER_1411 as t left join UMPAY.T_BANK_INF as bank on bank.BANKID=t.BANKID left join UMPAY.T_GOODS_INF goods on goods.GOODSID=t.GOODSID and goods.MERID=t.MERID left join UMPAY.T_MER_INF as mer on t.MERID=mer.MERID) prim group by prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME

select prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME,prim.ORDERSTATE,COUNT(prim.ORDERSTATE) ORDERCOUNT from (select t.*,bank.BANKNAME,goods.GOODSNAME,mer.MERNAME from UMPAY.T_UPORDER_1411 as t left join UMPAY.T_BANK_INF as bank on bank.BANKID=t.BANKID left join UMPAY.T_GOODS_INF goods on goods.GOODSID=t.GOODSID and goods.MERID=t.MERID left join UMPAY.T_MER_INF as mer on t.MERID=mer.MERID) prim where prim.MERID=group by prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME,prim.ORDERSTATE

select prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME,prim.ORDERSTATE,COUNT(prim.ORDERSTATE) ORDERCOUNT from (select t.*,bank.BANKNAME,goods.GOODSNAME,mer.MERNAME from UMPAY.T_UPORDER_1411 as t left join UMPAY.T_BANK_INF as bank on bank.BANKID=t.BANKID left join UMPAY.T_GOODS_INF goods on goods.GOODSID=t.GOODSID and goods.MERID=t.MERID left join UMPAY.T_MER_INF as mer on t.MERID=mer.MERID) prim where prim.MERID='9996    ' and prim.GOODSID='100     ' and prim.BANKNAME='北京小额' group by prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME,prim.ORDERSTATE

select prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKID,prim.BANKNAME,COUNT(prim.ORDERSTATE) ORDERCOUNT from (select t.*,bank.BANKNAME,goods.GOODSNAME,mer.MERNAME from UMPAY.T_UPORDER_1411 as t left join UMPAY.T_BANK_INF as bank on bank.BANKID=t.BANKID left join UMPAY.T_GOODS_INF goods on goods.GOODSID=t.GOODSID and goods.MERID=t.MERID left join UMPAY.T_MER_INF as mer on t.MERID=mer.MERID) prim group by prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKID,prim.BANKNAME

select prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME,prim.ORDERSTATE,COUNT(prim.ORDERSTATE) ORDERCOUNT from (select t.*,bank.BANKNAME,goods.GOODSNAME,mer.MERNAME from UMPAY.T_UPORDER_1411 as t left join UMPAY.T_BANK_INF as bank on bank.BANKID=t.BANKID left join UMPAY.T_GOODS_INF goods on goods.GOODSID=t.GOODSID and goods.MERID=t.MERID left join UMPAY.T_MER_INF as mer on t.MERID=mer.MERID) prim where prim.MERID='"+merid +"' and prim.GOODSID='"+goodsid+"' and prim.BANKNAME='"+bankname+"' group by prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME,prim.ORDERSTATE

select MERID,GOODSID,BANKID,ORDERSTATE,COUNT(ORDERSTATE) ORDERCOUNT from UMPAY.T_UPORDER_1411 where MERID='"+merid +"' and GOODSID='"+goodsid+"' and BANKID='"+bankid+"'   group by MERID,GOODSID,BANKID,ORDERSTATE

select MERID,GOODSID,BANKID,TRANSTATE,COUNT(TRANSTATE) TRANSCOUNT from UMPAY.T_UPTRANS_1411 where MERID='9996    ' and GOODSID='100     ' and BANKID='XE010000'   group by MERID,GOODSID,BANKID,TRANSTATE

select MERID,GOODSID,BANKID,TRANSTATE,COUNT(TRANSTATE) TRANSCOUNT from UMPAY.T_UPTRANS_1411 where TRANSDATE='20141113' and MERID='9996    ' and GOODSID='100     ' and BANKID='XE010000'   group by MERID,GOODSID,BANKID,TRANSTATE

select prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME,SUM(prim.AMOUNT) TOTALAMOUNT from (select t.*,bank.BANKNAME,goods.GOODSNAME,mer.MERNAME from UMPAY.T_UPTRANS_1411 as t left join UMPAY.T_BANK_INF as bank on bank.BANKID=t.BANKID left join UMPAY.T_GOODS_INF goods on goods.GOODSID=t.GOODSID and goods.MERID=t.MERID left join UMPAY.T_MER_INF as mer on t.MERID=mer.MERID) prim where prim.TRANSDATE='20141113' and prim.TRANSTATE=0 group by prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME

select prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKID,prim.BANKNAME,prim.TRANSTATE,COUNT(prim.TRANSTATE) TRANSCOUNT,SUM(prim.AMOUNT) TOTALAMOUNT from (select t.*,bank.BANKNAME,goods.GOODSNAME,mer.MERNAME from UMPAY.T_UPTRANS_1411 as t left join UMPAY.T_BANK_INF as bank on bank.BANKID=t.BANKID left join UMPAY.T_GOODS_INF goods on goods.GOODSID=t.GOODSID and goods.MERID=t.MERID left join UMPAY.T_MER_INF as mer on t.MERID=mer.MERID) prim where prim.TRANSDATE='20141114' group by prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME,prim.BANKID,prim.TRANSTATE

select prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKID,prim.BANKNAME,prim.TRANSTATE,COUNT(prim.TRANSTATE) TRANSCOUNT,SUM(prim.AMOUNT) TOTALAMOUNT from (select t.MERID,t.GOODSID,t.BANKID,t.TRANSTATE,t.TRANSDATE,t.AMOUNT,bank.BANKNAME,goods.GOODSNAME,mer.MERNAME from UMPAY.T_UPTRANS_1411 as t left join UMPAY.T_BANK_INF as bank on bank.BANKID=t.BANKID left join UMPAY.T_GOODS_INF goods on goods.GOODSID=t.GOODSID and goods.MERID=t.MERID left join UMPAY.T_MER_INF as mer on t.MERID=mer.MERID) prim where prim.TRANSDATE='20141114' group by prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME,prim.BANKID,prim.TRANSTATE

select prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKID,prim.BANKNAME,COUNT(prim.ORDERSTATE) ORDERCOUNT from (select t.*,bank.BANKNAME,goods.GOODSNAME,mer.MERNAME from UMPAY.T_UPORDER_1411 as t left join UMPAY.T_BANK_INF as bank on bank.BANKID=t.BANKID left join UMPAY.T_GOODS_INF goods on goods.GOODSID=t.GOODSID and goods.MERID=t.MERID left join UMPAY.T_MER_INF as mer on t.MERID=mer.MERID) prim where prim.ORDERDATE='20141114' group by prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKID,prim.BANKNAME

select prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKID,prim.BANKNAME,COUNT(prim.ORDERSTATE) ORDERCOUNT from (select t.MERID,t.GOODSID,t.BANKID,t.ORDERDATE,t.ORDERSTATE,bank.BANKNAME,goods.GOODSNAME,mer.MERNAME from UMPAY.T_UPORDER_1411 as t left join UMPAY.T_BANK_INF as bank on bank.BANKID=t.BANKID left join UMPAY.T_GOODS_INF goods on goods.GOODSID=t.GOODSID and goods.MERID=t.MERID left join UMPAY.T_MER_INF as mer on t.MERID=mer.MERID) prim where prim.ORDERDATE='20141114' group by prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKID,prim.BANKNAME

select trans.merid, mer.mername, trans.goodsid, goods.goodsname, trans.bankid, bank.bankname, trans.transtate, count(trans.transtate) as TRANSCOUNT,sum(amount) as TOTALAMOUNT
        from umpay.T_UPTRANS_1411 trans left join umpay.t_mer_inf mer on trans.merid=mer.merid
        left join umpay.t_goods_inf goods on trans.merid=goods.merid and trans.goodsid=goods.goodsid
        left join umpay.t_bank_inf bank on trans.bankid=bank.bankid
        where trans.TRANSDATE='20141114'
        group by trans.merid, mer.mername, trans.goodsid, goods.goodsname, trans.bankid, bank.bankname, trans.transtate
        
select trans.merid, mer.mername, trans.goodsid, goods.goodsname, trans.bankid, bank.bankname, trans.transtate, count(trans.transtate) as TRANSCOUNT,sum(amount) as TOTALAMOUNT
        from umpay.T_UPTRANS_1411 trans left join umpay.t_mer_inf mer on trans.merid=mer.merid
        left join umpay.t_goods_inf goods on trans.merid=goods.merid and trans.goodsid=goods.goodsid
        left join umpay.t_bank_inf bank on trans.bankid=bank.bankid
        where trans.transdate='20141114'
        group by trans.merid, mer.mername, trans.goodsid, goods.goodsname, trans.bankid, bank.bankname, trans.transtate;
        
        select o.merid, mer.mername, o.goodsid, goods.goodsname, o.bankid, bank.bankname, count(o.orderstate) as ORDERCOUNT,sum(amount) as TOTALAMOUNT
        from umpay.T_UPORDER_1411 o left join umpay.t_mer_inf mer on o.merid=mer.merid
        left join umpay.t_goods_inf goods on o.merid=goods.merid and o.goodsid=goods.goodsid
        left join umpay.t_bank_inf bank on o.bankid=bank.bankid
        where o.orderdate='20141114'
        group by o.merid, mer.mername, o.goodsid, goods.goodsname, o.bankid, bank.bankname;
        
        
        
        select trans.merid, mer.mername, trans.goodsid, goods.goodsname, trans.bankid, bank.bankname, trans.transtate, count(trans.transtate) as TRANSCOUNT,sum(amount) as TOTALAMOUNT
        from umpay.T_UPTRANS_1411 trans left join umpay.t_mer_inf mer on trans.merid=mer.merid
        left join umpay.t_goods_inf goods on trans.merid=goods.merid and trans.goodsid=goods.goodsid
        left join umpay.t_bank_inf bank on trans.bankid=bank.bankid
        where trans.transdate='20141114'
        group by trans.merid, mer.mername, trans.goodsid, goods.goodsname, trans.bankid, bank.bankname, trans.transtate;
        
        select trans.merid, mer.mername, trans.goodsid, goods.goodsname, trans.bankid, bank.bankname, trans.transtate, count(trans.transtate) as TRANSCOUNT,sum(amount) as TOTALAMOUNT
        from umpay.T_UPTRANS_1411 trans left join umpay.t_mer_inf mer on trans.merid=mer.merid
        left join umpay.t_goods_inf goods on trans.merid=goods.merid and trans.goodsid=goods.goodsid
        left join umpay.t_bank_inf bank on trans.bankid=bank.bankid
        where trans.transdate='20141114'
        group by trans.merid, mer.mername, trans.goodsid, goods.goodsname, trans.bankid, bank.bankname, trans.transtate;
        
        select trans.PLATORDID,trans.INTIME from (select t.* from umpay.T_UPTRANS_1411 t order by trans.INTIME desc) trans where trans.transdate='20141107' and trans.PLATORDID LIKE '%1155' group by trans.PLATORDID order by trans.INTIME desc
        
        select trans.PLATORDID,trans.INTIME from umpay.T_UPTRANS_1411  trans where trans.transdate='20141107'  order by trans.INTIME desc
        
        select trans.PLATORDID,trans.INTIME from umpay.T_UPTRANS_1411  trans where trans.transdate='20141107' and trans.PLATORDID LIKE '%1155'  order by trans.INTIME desc
        
      --   select distinct trans.PLATORDID,trans.INTIME from umpay.T_UPTRANS_1411 trans where trans.transdate='20141107' and trans.PLATORDID LIKE '%1155' order by trans.INTIME
      
         select   max(trans.INTIME) initime from umpay.T_UPTRANS_1411 trans where trans.transdate='20141107' and trans.PLATORDID LIKE '%1155'  order by initime desc

         --ok
         select   trans.merid,trans.goodsid,trans.bankid,trans.PLATORDID, max(trans.INTIME) initime from umpay.T_UPTRANS_1411 trans where trans.transdate='20141112' group by trans.merid,trans.goodsid,trans.bankid,trans.PLATORDID  order by initime

         --ok
         select   trans.merid,trans.goodsid,trans.bankid,trans.PLATORDID, sum(trans.amount) as TOTALAMOUNT,max(trans.INTIME) initime from umpay.T_UPTRANS_1411 trans where trans.transdate='20141107' group by trans.merid,trans.goodsid,trans.bankid,trans.PLATORDID  order by initime
         --sub query
         select t.MERID,t.GOODSID,t.BANKID,t.TRANSTATE,t.TRANSDATE,t.AMOUNT,t.PLATORDID, max(t.INTIME) initime from UMPAY.T_UPTRANS_1411 as t 
         --combin ok
         select trans.merid, mer.mername, trans.goodsid, goods.goodsname, trans.bankid, bank.bankname, trans.transtate, count(trans.transtate) as TRANSCOUNT,sum(trans.amount) as TOTALAMOUNT
        from ( 
        select t.MERID,t.GOODSID,t.BANKID,t.TRANSTATE,t.TRANSDATE,t.PLATORDID, t.amount, max(t.INTIME) initime from UMPAY.T_UPTRANS_1411 as t 
		where t.transdate='20141107' group by t.merid,t.goodsid,t.bankid,t.PLATORDID,t.TRANSDATE,t.TRANSTATE,t.amount
		) trans 
		left join umpay.t_mer_inf mer on trans.merid=mer.merid
        left join umpay.t_goods_inf goods on trans.merid=goods.merid and trans.goodsid=goods.goodsid
        left join umpay.t_bank_inf bank on trans.bankid=bank.bankid
        where trans.transdate='20141107'
        group by trans.merid, mer.mername, trans.goodsid, goods.goodsname, trans.bankid, bank.bankname, trans.transtate;
        
        --order
        select o.merid, mer.mername, o.goodsid, goods.goodsname, o.bankid, bank.bankname, count(o.orderstate) as ORDERCOUNT,sum(amount) as TOTALAMOUNT  from umpay.T_UPORDER_1411 o left join umpay.t_mer_inf mer on o.merid=mer.merid left join umpay.t_goods_inf goods on o.merid=goods.merid and o.goodsid=goods.goodsid left join umpay.t_bank_inf bank on o.bankid=bank.bankid  where o.orderdate='20141112' group by o.merid, mer.mername, o.goodsid, goods.goodsname, o.bankid, bank.bankname
        
        --the real run
        select trans.merid, mer.mername, trans.goodsid, goods.goodsname, trans.bankid, bank.bankname, trans.transtate, count(trans.transtate) as TRANSCOUNT,sum(trans.amount) as TOTALAMOUNT     from ( select t.MERID,t.GOODSID,t.BANKID,t.TRANSTATE,t.TRANSDATE,t.PLATORDID, t.amount, max(t.INTIME) initime from UMPAY.T_UPTRANS_1411 as t where t.transdate='20141107' group by t.merid,t.goodsid,t.bankid,t.PLATORDID,t.TRANSDATE,t.TRANSTATE,t.amount      ) trans left join umpay.t_mer_inf mer on trans.merid=mer.merid      left join umpay.t_goods_inf goods on trans.merid=goods.merid and trans.goodsid=goods.goodsid        left join umpay.t_bank_inf bank on trans.bankid=bank.bankid     where trans.transdate='20141107'        group by trans.merid, mer.mername, trans.goodsid, goods.goodsname, trans.bankid, bank.bankname, trans.transtate
         --combin ok
         select trans.merid, mer.mername, trans.goodsid, goods.goodsname, trans.bankid, bank.bankname, trans.transtate, count(trans.transtate) as TRANSCOUNT,sum(trans.amount) as TOTALAMOUNT
        from ( 
        select t.MERID,t.GOODSID,t.BANKID,t.TRANSTATE,t.TRANSDATE,t.PLATORDID, t.amount, max(t.INTIME) initime from UMPAY.T_UPTRANS_1411 as t 
		where t.transdate='20141112' group by t.merid,t.goodsid,t.bankid,t.PLATORDID,t.TRANSDATE,t.TRANSTATE,t.amount
		) trans 
		left join umpay.t_mer_inf mer on trans.merid=mer.merid
        left join umpay.t_goods_inf goods on trans.merid=goods.merid and trans.goodsid=goods.goodsid
        left join umpay.t_bank_inf bank on trans.bankid=bank.bankid
        where trans.transdate='20141112'
        group by trans.merid, mer.mername, trans.goodsid, goods.goodsname, trans.bankid, bank.bankname, trans.transtate;
        