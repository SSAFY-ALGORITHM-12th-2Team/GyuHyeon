-- 코드를 입력하세요
SELECT ingredient_type, sum(total_order) as total_order
from first_half join icecream_info using (flavor)
group by ingredient_type
order by total_order;