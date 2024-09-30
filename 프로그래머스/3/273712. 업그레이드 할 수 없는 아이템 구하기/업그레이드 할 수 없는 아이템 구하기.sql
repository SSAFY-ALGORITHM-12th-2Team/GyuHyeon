-- 코드를 작성해주세요
select item_id, item_name, rarity
from item_info
where item_id not in (select distinct ifnull(parent_item_id, 0) from item_tree)
order by item_id desc;