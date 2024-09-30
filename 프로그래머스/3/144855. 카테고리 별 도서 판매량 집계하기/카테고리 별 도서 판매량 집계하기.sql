-- 코드를 입력하세요
SELECT category, sum(sales) as total_sales
from book join book_sales
using (book_id)
where sales_date like('2022-01-__')
group by category
order by category;