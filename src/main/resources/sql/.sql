SELECT * FROM 
bison.brand b,
bison.amz_seller  se,
bison.amz_region ar
where b.brand_id = se.brand_id
and se.amazon_region_id = ar.amz_region_id	
and ar.region_status = 1
and b.brand_id = 1
and se.`status` = 1