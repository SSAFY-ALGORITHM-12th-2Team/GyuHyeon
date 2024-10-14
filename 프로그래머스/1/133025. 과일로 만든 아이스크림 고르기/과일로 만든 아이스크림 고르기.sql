-- 코드를 입력하세요
SELECT first_half.flavor from first_half 
left join icecream_info using (flavor)
where total_order >= 3000 and ingredient_type = "fruit_based"
order by total_order desc