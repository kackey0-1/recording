import { z } from 'zod';

export const zBookRecord = z.object({
  bookId: z.number().int(),
  title: z.string(),
  readDate: z.string().date(),
  amount: z.number().int(),
});
export const zBookRecords = z.array(zBookRecord);

export type BookRecord = z.infer<typeof zBookRecord>;
export type BookRecords = z.infer<typeof zBookRecords>;
