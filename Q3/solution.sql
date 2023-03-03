SELECT o.owner_id, o.owner_name, sub.different_category_count
FROM owner o
JOIN (    
        SELECT a.owner_id, c.different_category_count
        FROM article a
        JOIN (SELECT article_id, COUNT(DISTINCT category_id) as different_category_count
        FROM category_article_mapping
        GROUP BY article_id) c ON a.article_id = c.article_id
    ) sub ON o.owner_id = sub.owner_id
ORDER BY sub.different_category_count DESC