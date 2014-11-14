select MERID,GOODSID,BANKID,SUM(AMOUNT) TOTALAMOUNT from UMPAY.T_UPTRANS_1411  group by MERID,GOODSID,BANKID


select UPTRANS.MERID,UPTRANS.GOODSID,UPTRANS.BANKID,SUM(UPTRANS.AMOUNT) TOTALAMOUNT from UMPAY.T_UPTRANS_1411 UPTRANS group by UPTRANS.MERID,UPTRANS.GOODSID,UPTRANS.BANKID

select prim.MERID,prim.GOODSID,prim.BANKID,SUM(prim.AMOUNT) TOTALAMOUNT from UMPAY.T_UPTRANS_1411 as prim  left join UMPAY.T_BANK_INF as bank on bank.BANKID=PRIM.BANKID

select prim.MERID,prim.GOODSID,prim.BANKID,SUM(prim.AMOUNT) TOTALAMOUNT from UMPAY.T_UPTRANS_1411 as prim  left join UMPAY.T_BANK_INF as bank on bank.BANKID=PRIM.BANKID group by MERID,GOODSID,BANKID

select prim.MERID,prim.GOODSID,prim.BANKID, bank.BANKNAME from UMPAY.T_UPTRANS_1411 as prim  left join UMPAY.T_BANK_INF as bank on bank.BANKID=PRIM.BANKID 

select prim.MERID,prim.GOODSID,prim.BANKID, bank.BANKNAME from UMPAY.T_UPTRANS_1411 as prim  left join UMPAY.T_BANK_INF as bank on bank.BANKID=PRIM.BANKID  group by primn.MERID,primn.GOODSID,primn.BANKID
--BANKNAME
select prim.MERID,prim.GOODSID,prim.BANKID, prim.BANKNAME from (select t.*,bank.BANKNAME from UMPAY.T_UPTRANS_1411 as t left join UMPAY.T_BANK_INF as bank on bank.BANKID=t.BANKID ) prim group by prim.MERID,prim.GOODSID,prim.BANKID,prim.BANKNAME
--GOODSNAME+BANKNAME+MERNAME(full except Amount sum)
select prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKID, prim.BANKNAME from (select t.*,bank.BANKNAME,goods.GOODSNAME,mer.MERNAME from UMPAY.T_UPTRANS_1411 as t left join UMPAY.T_BANK_INF as bank on bank.BANKID=t.BANKID left join UMPAY.T_GOODS_INF goods on goods.GOODSID=t.GOODSID and goods.MERID=t.MERID left join UMPAY.T_MER_INF as mer on t.MERID=mer.MERID) prim group by prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKID,prim.BANKNAME
--full ok!
select prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME,SUM(prim.AMOUNT) TOTALAMOUNT from (select t.*,bank.BANKNAME,goods.GOODSNAME,mer.MERNAME from UMPAY.T_UPTRANS_1411 as t left join UMPAY.T_BANK_INF as bank on bank.BANKID=t.BANKID left join UMPAY.T_GOODS_INF goods on goods.GOODSID=t.GOODSID and goods.MERID=t.MERID left join UMPAY.T_MER_INF as mer on t.MERID=mer.MERID) prim group by prim.MERID,prim.MERNAME,prim.GOODSID,prim.GOODSNAME,prim.BANKNAME

