# big_data_project
Big Data final project ETL and Profiling process

## input:
1. dota_data.csv - original dota data obtained from Open Dota API data explorer (https://www.opendota.com/explorer?)
3. tail_games1-4.csv - original league of legends data obtained from Kaggle (https://www.kaggle.com/kdanielive/lol-partchallenger-1087?select=tail_games4.csv)
3. riot_champion.csv - original league of legends champion data with id obtained from Kaggle (https://www.kaggle.com/gyejr95/league-of-legendslol-champion-and-item-2020)

## Output.zip: 
1. zipped file for cleaned and profiled outputs
2. champion_clean.csv - cleaned riot_champion.csv file
3. dota_hero.csv - original dota hero data obtained from Open Dota API data explorer (https://www.opendota.com/explorer?). No cleaning needed.
4. game_output.csv - cleaned dota and league match data from dota_data.csv and tail_games1-4.csv, merged together on HDFS

## data_profiling
1. CountRecs contains java mapreduce code written to count the number of records in the dataset
2. original_results - number of records before cleaning for the 4 input datasets
3. cleaned_result - number of records after cleaning

## data_cleaning:
1. dota_cleaning - mapreduce job to clean dota_data.csv, output dota_clean.csv. We dropped useless columns and added a column to indicate if it's a dota game.
2. lol_cleaning1-4 - mapreduce jobs to clean tail_games1-4.csv separately, output lol_clean1-4.csv. We dropped useless columns and rows, added a column to indicate if it's a league game, splitted one row each match with 1518 columns to around 20 rows per match to made it same schema as dota_clean.csv. Since the four orginal datasets's columns are different (no patterns where columns we need are located), we processed each dataset separately.
3. hero - mapreduce jobs to clean riot_champions.csv, output champion_clean.csv. We dropped useless columns and mantained only id and name
4. merged_file.png - screenshot from peel command to merge game output datasets together (from dota_clean.csv and lol_clean1-4.csv to game_output.csv)
    





 


